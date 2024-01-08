package com.example.tacos.repository;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.domain.Taco;
import com.example.tacos.domain.TacoOrder;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

    private JdbcOperations jdbcOperations;

    public OrderRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrder saveOrder(TacoOrder order) {
        PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(
                "insert into Taco_Order(delivery_Name, delivery_Street, delivery_City, delivery_State, " +
                        "delivery_Zip, cc_Number, cc_Expiration, cc_CVV, order_Date) " +
                        "values(?,?,?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP);
        factory.setReturnGeneratedKeys(true);
        order.setOrderDate(new Date());
        PreparedStatementCreator statement = factory.newPreparedStatementCreator(
                Arrays.asList(
                        order.getDeliveryName(),order.getDeliveryStreet(), order.getDeliveryCity(),
                        order.getDeliveryState(), order.getDeliveryZip(), order.getCcNumber(),
                        order.getCcExpiry(), order.getCcCVV(), order.getOrderDate()
                )
        );
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(statement, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setOrderId(orderId);
        AtomicInteger i= new AtomicInteger();
        order.getTacos().forEach(taco -> saveTaco(orderId, i.getAndIncrement(), taco));
        return order;
    }

    private long saveTaco(long orderId, int orderKey, Taco taco) {
        taco.setCreatedOn(new Date());
        PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(
                "insert into Taco(name, created_On, taco_Order, taco_Order_Key) values(?,?,?,?)",
                Types.VARCHAR,Types.TIMESTAMP, Type.LONG, Type.LONG
        );
        factory.setReturnGeneratedKeys(true);
        PreparedStatementCreator statement = factory.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(), taco.getCreatedOn(), orderId, orderKey
                )
        );
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(statement, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setTacoId(tacoId);
        saveIngredientRefs(tacoId, taco.getIngredients());
        return tacoId;
    }

    private void saveIngredientRefs(long tacoId, List<Ingredient> ingredients) {
        int key=0;
        for(Ingredient ingredient: ingredients) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref(ingredient, taco, taco_Key) values(?,?,?)",
                    ingredient.getId(), tacoId, key++
            );
        }
    }
}
