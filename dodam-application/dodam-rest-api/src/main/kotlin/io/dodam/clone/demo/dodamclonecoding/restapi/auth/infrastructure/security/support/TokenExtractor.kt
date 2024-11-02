package io.dodam.clone.demo.dodamclonecoding.restapi.auth.infrastructure.security.support

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpHeaders
import java.util.*

class TokenExtractor {
    companion object {
        fun extract(
            request: HttpServletRequest,
            type: String
        ): String? {
            val access: Enumeration<String> = request.getHeaders(HttpHeaders.AUTHORIZATION)
            while (access.hasMoreElements()) {
                val value: String? = access.nextElement()
                if (value?.startsWith(type) == true) {
                    return value.substring(type.length).trim()
                }
            }
            return null
        }
    }
}