package zw.dreamhub.services.impl

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import zw.dreamhub.domain.dto.request.QrRequest
import zw.dreamhub.domain.dto.response.ApiResponse
import zw.dreamhub.domain.utils.Narration
import zw.dreamhub.services.QRCodeGeneratorService
import zw.dreamhub.services.QrService

@Service
class QrServiceImpl(private val service: QRCodeGeneratorService) : QrService {
    override fun createQrCodes(request: QrRequest): ApiResponse<String> {
        request.data.stream().forEach { service.generate(it) }
        return ApiResponse(
            true, HttpStatus.CREATED.value(),
            Narration.SUCCESS.name, Narration.SUCCESS.name
        )
    }
}