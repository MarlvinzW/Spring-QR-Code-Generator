package zw.dreamhub.domain.dto.response

/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 19/5/2023
 */
data class ApiResponse<T>(
    val successful: Boolean,
    val status: Int,
    val narration: String,
    val data: T
)
