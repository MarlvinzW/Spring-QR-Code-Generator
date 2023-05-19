package zw.dreamhub.controllers

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import zw.dreamhub.domain.dto.request.QrRequest
import zw.dreamhub.domain.dto.response.ApiResponse
import zw.dreamhub.services.QrService


/**
 * @author Marlvin Chihota
 * Email marlvinchihota@gmail.com
 * Created on 19/5/2023
 */
@RestController
@RequestMapping("\${info.url.unSecured}")
@Tag(name = "QR Code Controller", description = "manage qr codes")
class QrController(private val service: QrService) {

    @PostMapping("/qr")
    @Operation(summary = "Create QR codes", description = "create QR code images from given data")
    fun createQrCodes(@RequestBody request: QrRequest): ResponseEntity<ApiResponse<String>> {
        val response: ApiResponse<String> = service.createQrCodes(request)
        return ResponseEntity.status(response.status).body(response)
    }

}