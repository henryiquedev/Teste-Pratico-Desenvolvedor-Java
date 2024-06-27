package com.teste.pratico.converter;

import com.teste.pratico.bean.SolicitanteBean;
import com.teste.pratico.model.Solicitante;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("solicitanteConverter")
public class SolicitanteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Long id = Long.parseLong(value);
            SolicitanteBean solicitanteBean = context.getApplication().evaluateExpressionGet(context, "#{solicitanteBean}", SolicitanteBean.class);
            return solicitanteBean.findSolicitanteById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Solicitante) {
            return ((Solicitante) value).getId().toString();
        } else {
            throw new IllegalArgumentException("Objeto não é do tipo Solicitante");
        }
    }
}