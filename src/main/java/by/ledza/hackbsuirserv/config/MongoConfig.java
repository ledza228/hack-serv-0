package by.ledza.hackbsuirserv.config;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Objects;

@Configuration
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoClientFactoryBean mongoClientFactoryBean() {
        MongoClientFactoryBean factoryBean = new MongoClientFactoryBean();
        String uri = env.getProperty("spring.data.mongodb.uri");
        factoryBean.setConnectionString(new ConnectionString(uri));
        return factoryBean;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        return new MongoTemplate(
                Objects.requireNonNull(mongoClientFactoryBean().getObject()),
                Objects.requireNonNull(env.getProperty("spring.data.mongodb.database")));
    }
}
