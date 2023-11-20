package global.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import global.error.ErrorResponse.CustomErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomException e) {
            logger.error(e);
            sendErrorMessage(response, e.getErrorCode());
        } catch (Exception e) {
            logger.error(e);
            sendErrorMessage(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendErrorMessage(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        CustomErrorResponse customErrorResponse = CustomErrorResponse.builder()
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .build();
        String errorResponseJson = objectMapper.writeValueAsString(customErrorResponse);

        response.setStatus(errorCode.getStatus());
        response.setContentType("application/Jason");
        response.getWriter().write(errorResponseJson);
    }
}