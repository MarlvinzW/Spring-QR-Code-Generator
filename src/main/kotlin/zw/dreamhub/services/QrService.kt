package zw.dreamhub.services

import zw.dreamhub.domain.dto.request.QrRequest
import zw.dreamhub.domain.dto.response.ApiResponse


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 19/5/2023
 */
interface QrService {
    fun createQrCodes(request: QrRequest): ApiResponse<String>
}