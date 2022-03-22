package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateViolenceType {

    private final ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    public ViolenceType execute(ViolenceType violenceType) {
        return violenceTypePersistenceGateway.save(violenceType);
    }
}
