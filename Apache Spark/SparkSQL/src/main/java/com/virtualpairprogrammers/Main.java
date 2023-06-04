package com.virtualpairprogrammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.Partition;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.*;

import scala.Tuple2;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		System.setProperty("hadoop.home.dir", "c:/hadoop");
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		//create a spark session
		SparkSession spark = SparkSession.builder()
							.appName("testingSparkSql")
							.master("local[*]")
							.getOrCreate();
		// read csv file into a dataset
		Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/exams/students.csv");
		// show top 20 records
//		dataset.show();
//		System.out.println("Total records in dataset: " +dataset.count());
//		get first row/record in dataset
//		Row firstRow = dataset.first();
		// get third column from a row
//		String subject = firstRow.get(2).toString();
//		System.out.println(subject);
		// if we are reading header using option also then get subject column from first row
//		String subjectSame = firstRow.getAs("subject").toString();
//		System.out.println(subjectSame);
//		int year = Integer.parseInt(firstRow.getAs("year"));
//		System.out.println(year);
		// filter dataset using sql like syntax
//		Dataset<Row> modernArtResults = dataset.filter("subject='Modern Art' and year>='2007'");
//		modernArtResults.show();
		// filter dataset using lambda function
//		dataset.filter(row->row.getAs("subject").equals("Modern Art")
//						&& Integer.parseInt(row.getAs("year"))>=2007)
//						.show();
//		Column subject = dataset.col("subject");
//		Column year = dataset.col("year");
		// filter using coding style
//		dataset.filter(subject.equalTo("Modern Art").and(year.geq(2007))).show();
//		Column subject = column("subject");
//		Column year = column("year");
		// filter using functions imported as static import
//		dataset.filter(
//				column("subject").equalTo("Modern Art")
//						.and(
//								column("year").geq(2007)))
//				.show();
		// create an in memory view from dataset
		dataset.createOrReplaceTempView("my_students_view");
		// run sql query on created view
//		spark.sql("select * from my_students_view where subject='French' and year>=2007").show();
//		spark.sql("select max(score) from my_students_view").show();
		Dataset<Row> result = spark.sql("select distinct(year) from my_students_view order by year asc");
		result.show();
		spark.close();
	}

}
