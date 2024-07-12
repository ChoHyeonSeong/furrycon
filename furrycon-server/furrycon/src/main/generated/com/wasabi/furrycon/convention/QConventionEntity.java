package com.wasabi.furrycon.convention;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QConventionEntity is a Querydsl query type for ConventionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QConventionEntity extends EntityPathBase<ConventionEntity> {

    private static final long serialVersionUID = -1633103939L;

    public static final QConventionEntity conventionEntity = new QConventionEntity("conventionEntity");

    public final StringPath countryCode = createString("countryCode");

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final StringPath homepageUrl = createString("homepageUrl");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    public final StringPath name = createString("name");

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public QConventionEntity(String variable) {
        super(ConventionEntity.class, forVariable(variable));
    }

    public QConventionEntity(Path<? extends ConventionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConventionEntity(PathMetadata metadata) {
        super(ConventionEntity.class, metadata);
    }

}

