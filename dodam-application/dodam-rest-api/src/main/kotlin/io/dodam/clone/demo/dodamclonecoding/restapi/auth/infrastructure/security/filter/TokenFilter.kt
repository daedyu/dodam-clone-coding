package io.dodam.clone.demo.dodamclonecoding.restapi.auth.infrastructure.security.filter

import io.dodam.clone.demo.dodamclonecoding.restapi.auth.infrastructure.security.support.TokenExtractor
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class TokenFilter: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token: String? = TokenExtractor.extract(request, "Bearer")
    }
}