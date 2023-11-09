    package br.joaquim.forum.infra

    import br.joaquim.forum.model.error.Error
    import com.fasterxml.jackson.databind.JsonMappingException
    import jakarta.persistence.EntityNotFoundException
    import org.springframework.http.HttpInputMessage
    import org.springframework.http.HttpStatus
    import org.springframework.http.converter.HttpMessageNotReadableException
    import org.springframework.validation.FieldError
    import org.springframework.web.bind.MethodArgumentNotValidException
    import org.springframework.web.bind.annotation.ExceptionHandler
    import org.springframework.web.bind.annotation.ResponseStatus
    import org.springframework.web.bind.annotation.RestControllerAdvice

    @RestControllerAdvice
    class ExceptionHandler {

        @ExceptionHandler(EntityNotFoundException::class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        fun handleNotFound(): Error {
            return Error(message = "Id inexistente.")
        }


        @ExceptionHandler(MethodArgumentNotValidException::class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        fun handleNotValid(ex: MethodArgumentNotValidException): List<ValidationFields> {
            val errors = ex.fieldErrors
            return errors.map{
                ValidationFields(it.field, it.defaultMessage)
            }
        }

        @ExceptionHandler(HttpMessageNotReadableException::class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        fun handleNullField(ex: HttpMessageNotReadableException): Map<String, Any> {
            val rootCause = ex.rootCause
            if (rootCause is JsonMappingException) {
                val pathReference = rootCause.pathReference
                pathReference?.let {
                    val fieldPath = rootCause.path.joinToString(separator = ".") { it.fieldName }
                    return mapOf (
                        "error" to "JSON mal formado.",
                        "message" to "Campo \"$fieldPath\" está ausente ou tem valor inválido"
                    )
                }
            }

            return mapOf(
                "error" to "JSON mal formado.",
                "message" to "Cheque campos obrigatórios."
            )
        }

        data class ValidationFields(
            val field: String,
            val message: String?
        )
    }