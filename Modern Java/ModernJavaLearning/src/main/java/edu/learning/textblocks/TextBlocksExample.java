package edu.learning.textblocks;

public class TextBlocksExample {
    private static void multiLineString(){
        String multiLine = """
                This is
                a multiline string
                demo
                """;
        System.out.println(multiLine);
    }
    private static void multiLineWithParam(String input){
        String multiline = """
                This is a
                multiline string
                with param %s
                """.formatted(input);
        System.out.println(multiline);
    }
    private static void sql(int id, String name){
        String statement = """
                select order_id, order_name
                from orders
                where order_id=%s
                and order_name=%s
                """.formatted(id,name);
        System.out.println(statement);
    }
    private static void json(){
        String json= """
                {
                "order_id":12,
                "order_name":"Power_Bank
                }
                """;
        System.out.println(json);
    }
    public static void main(String[] args) {
        multiLineString();
        multiLineWithParam("MyParam");
        sql(12,"Power_Bank");
        json();
    }
}
