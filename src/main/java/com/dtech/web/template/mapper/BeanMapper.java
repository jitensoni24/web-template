package com.dtech.web.template.mapper;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

/**
 * Orika mapper exposed as a Spring Bean. It contains the configuration for the mapper
 * factory and factory builder. It will scan the Spring application context searching
 * for mappers and converters and register them into the factory.
 */
@Component
public class BeanMapper extends ConfigurableMapper {
    @Autowired
    private ApplicationContext applicationContext;

    private MapperFactory factory;

    public BeanMapper() {
        super(false);
    }

    @Override
    @PostConstruct
    public void init() {
        super.init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure(MapperFactory factory) {
        this.factory = factory;

        addAllSpringBeans(applicationContext);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        factoryBuilder.mapNulls(false);
    }

    /**
     * Constructs and registers a {@link ClassMapBuilder} into the
     * {@link MapperFactory} using a {@link Mapper}.
     * 
     * @param mapper
     */

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addMapper(Mapper<?, ?> mapper) {
        factory.classMap(mapper.getAType(), mapper.getBType())
            .byDefault()
            .customize((Mapper) mapper)
            .register();
    }

    /**
     * Registers a {@link Converter} into the {@link ConverterFactory}.
     * 
     * @param converter
     */
    public void addConverter(Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }

    /**
     * Scans the application context and registers all Mappers and Converters.
     * 
     * @param applicationContext
     */
    @SuppressWarnings("rawtypes")
    private void addAllSpringBeans(final ApplicationContext applicationContext) {
        Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);

        for (Mapper mapper : mappers.values()) {
            addMapper(mapper);
        }

        Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);

        for (Converter converter : converters.values()) {
            addConverter(converter);
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }
}
