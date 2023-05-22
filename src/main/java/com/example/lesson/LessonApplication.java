package com.example.lesson;

import com.example.lesson.Service.PgProductService;
import com.example.lesson.Service.ProductService;
import com.example.lesson.record.ProductRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LessonApplication.class, args);

		ConfigurableApplicationContext context =
				SpringApplication.run(LessonApplication.class, args);

		ProductService productService = context.getBean(ProductService.class);

		var list = productService.findAll();
		list.stream().forEach(System.out::println);

		var product = productService.findById(1);
		System.out.println(product);

		var insert = productService.insert(new ProductRecord(4, "筆" , 500));
		System.out.println(insert);

		var update = productService.update(new ProductRecord(4, "絵具", 550));
		System.out.println(update);

		var delete = productService.delete(4);
		System.out.println(delete);
	}

}
