/**
 * A SpringBoot application similar to JabRef for managing bibliographies.
 * 
 * Allows the user to enter author, title, year, and journal to add a new entry 
 * to the bibliography collection.
 * 
 * Displays a list of all the bibliographies in the database.
 * Uses MySQL database for data storage. Just create a schema in your  
 * MySQL instance, and make sure you configure application.properties correctly.
 * Note: Currently, the default schema name is springbootfirstapp.
 *       By default, MySQL port is 6608, user name is root, and password is root.
 * 	     See application.properties if you wish to change any of these values.
 * 
 * Allows the user to modify or delete an existing bibliography.
 * 
 * Search feature has been implemented. Type a word and hit Enter, and any 
 * entry containing such word will be displayed in a table.
 * 
 * @author Amell Peralta
 * @version 1.0 3/18/2017
 */
package org.amell.youref.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class YouRef {
	@Autowired
	DatabaseBibliographyRepository repository;

	@Bean
	public Converter<String, Bibliography> bibliographyConverter() {
		return new Converter<String, Bibliography>() {
			@Override
			public Bibliography convert(String id) {
				return repository.findOne(Long.valueOf(id));
			}
		};
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(YouRef.class, args);
	}
}
