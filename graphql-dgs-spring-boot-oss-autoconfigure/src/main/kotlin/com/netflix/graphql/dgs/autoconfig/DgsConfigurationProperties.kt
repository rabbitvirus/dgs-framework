/*
 * Copyright 2021 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.graphql.dgs.autoconfig

import com.netflix.graphql.dgs.internal.DgsSchemaProvider.Companion.DEFAULT_SCHEMA_LOCATION
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.DefaultValue

/**
 * Configuration properties for DGS framework.
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "dgs.graphql")
@Suppress("ConfigurationProperties")
data class DgsConfigurationProperties(
    /** Location of the GraphQL schema files. */
    @DefaultValue(DEFAULT_SCHEMA_LOCATION) val schemaLocations: List<String>,
    /**
     * Setting this value to `false` will prevent Introspection queries from being performed.
     * Note that this is against GraphQL Specification, that said, some production systems want this lock down in place
     * for security concerns.
     */
    @DefaultValue("true") val introspectionEnabled: Boolean
)
