package com.suavoz.report.usecases.violenceType;

import com.suavoz.report.domain.ViolenceType;
import com.suavoz.report.gateways.persistence.ViolenceTypePersistenceGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListVIolenceTypes {

    private final ViolenceTypePersistenceGateway violenceTypePersistenceGateway;

    public List<ViolenceType> execute() {
        return violenceTypePersistenceGateway.findAll();
    }

}
