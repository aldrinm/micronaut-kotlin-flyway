package com.example

import graphql.GraphQL
import graphql.kickstart.tools.SchemaParser
import graphql.kickstart.tools.SchemaParserBuilder
import graphql.schema.GraphQLSchema
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import javax.inject.Singleton

@Factory
class GraphQLFactory {

    @Bean
    @Singleton
    fun graphQL(bookQueryResolver: BookQueryResolver, bookMutationResolver: BookMutationResolver): GraphQL {

        // Parse the schema.
        val builder: SchemaParserBuilder = SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(bookQueryResolver, bookMutationResolver)

        // Create the executable schema.
        val graphQLSchema: GraphQLSchema = builder.build().makeExecutableSchema()

        // Return the GraphQL bean.
        return GraphQL.newGraphQL(graphQLSchema).build()
    }

}