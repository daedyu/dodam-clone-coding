package io.dodam.clone.demo.dodamclonecoding.restapi.auth.infrastructure.security.configuration

import io.dodam.clone.demo.dodamclonecoding.restapi.auth.infrastructure.security.filter.TokenFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig() {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .formLogin { it.disable() }
            .httpBasic { it.disable() }
            .cors { it.disable() }

            .addFilterBefore(TokenFilter(), UsernamePasswordAuthenticationFilter::class.java)
            .authorizeHttpRequests { req ->
                req
                    .requestMatchers("/").permitAll()
                    .anyRequest().authenticated()
            }

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("*")
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH")
        configuration.allowedHeaders = listOf("*")

        configuration.maxAge = 3600L
        configuration.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()

        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}