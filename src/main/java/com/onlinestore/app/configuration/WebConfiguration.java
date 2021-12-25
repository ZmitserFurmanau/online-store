package com.onlinestore.app.configuration;

import com.onlinestore.app.component.LocalDateTimeConverter;
import com.onlinestore.app.dto.request.OrderRequestDto;
import com.onlinestore.app.dto.response.OrderResponseDto;
import com.onlinestore.app.model.Order;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Web configuration.
 */
@EnableWebMvc
public class WebConfiguration {
    /**
     * Mapper mapper.
     *
     * @return the mapper
     */
    @Bean
    public Mapper mapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<CustomConverter> converters = new ArrayList<>();
        converters.add(new LocalDateTimeConverter());
        dozerBeanMapper.setCustomConverters(converters);
        dozerBeanMapper.addMapping(mappingBuilder());
        return new DozerBeanMapper();
    }

    private BeanMappingBuilder mappingBuilder() {
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Order.class, OrderResponseDto.class).fields("date", "date",
                        FieldsMappingOptions.customConverter(LocalDateTimeConverter.class));
                mapping(OrderRequestDto.class, Order.class).fields("date", "date",
                        FieldsMappingOptions.customConverter(LocalDateTimeConverter.class));
            }
        };
    }

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
