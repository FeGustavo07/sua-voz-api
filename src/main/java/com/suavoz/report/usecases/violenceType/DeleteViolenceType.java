package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteViolenceType {

    private final ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    public void execute(ViolenceType violenceType) {
        violenceTypePersistenceGateway.delete(violenceType);
    }

}
