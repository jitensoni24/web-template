package com.dtech.web.template.mapper;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
 *
 * To use it we just need to autowire it into our class.
 */
public class OrikaBeanMapper extends ConfigurableMapper implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;

    private MapperFactory factory;

    public OrikaBeanMapper() {
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

    public <S, D> D convert(S source, Class<D> destinationClass) {
        return this.convert(source, destinationClass, null, null);
    }

    public <S, D> D convert(S source, Class<D> destinationClass, String converterId) {
        return this.convert(source, destinationClass, converterId, null);
    }

    /**
     * Scans the application context and registers all Mappers and Converters.
     *
     * @param applicationContext
     */
    private void addAllSpringBeans(final ApplicationContext applicationContext) {
        applicationContext.getBeansOfType(Mapper.class).values().forEach(this::addMapper);
        applicationContext.getBeansOfType(Converter.class).values().forEach(this::addConverter);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }
}
