package com.drone.manager.service.util.code.adapter;

import com.drone.manager.model.enums.CharCase;
import lombok.Data;

@Data
public abstract class AdapterAbstract {
    protected CharCase charCase;
    protected int codeLength = 10;

    public abstract String generate();

    public String toCase(String code){

        String converted = CharCase.UPPER_CASE.equals(this.charCase) ?
                code.toUpperCase() : CharCase.LOWER_CASE.equals(this.charCase) ?
                code.toLowerCase() : code;

        return converted;
    }

}
