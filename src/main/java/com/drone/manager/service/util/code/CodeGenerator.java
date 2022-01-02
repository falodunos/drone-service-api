package com.drone.manager.service.util.code;

import com.drone.manager.model.Medication;
import com.drone.manager.model.enums.CharCase;
import com.drone.manager.service.MedicationService;
import com.drone.manager.service.util.code.adapter.AdapterAbstract;
import com.drone.manager.service.util.code.adapter.Alphanumeric;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CodeGenerator {

    @Autowired
    MedicationService medicationService;

    protected AdapterAbstract adapter;

    public CodeGenerator() {
        this.setAdapter(new Alphanumeric());
    }

    public String generate(CharCase charCase, int codeLength) {
        String code = "";
        boolean isExisting = true;
        do {
            this.getAdapter().setCharCase(charCase);
            this.getAdapter().setCodeLength(codeLength);
            code = this.getAdapter().generate();
            Optional<Medication> optional = medicationService.getMedicationByCode(code);

            if (!optional.isPresent()) {
                isExisting = false;
            }
        } while (isExisting);

        return code;
    }
}
