package com.teste.pratico.converter;

import com.teste.pratico.bean.SolicitanteBean;
import com.teste.pratico.model.Solicitante;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.logging.Logger;

@FacesConverter("solicitanteConverter")
public class SolicitanteConverter implements Converter {

    private static final Logger LOGGER = Logger.getLogger(SolicitanteConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Long id = Long.parseLong(value);
            LOGGER.info("Converting String to Solicitante with ID: " + id);
            SolicitanteBean solicitanteBean = context.getApplication().evaluateExpressionGet(context, "#{solicitanteBean}", SolicitanteBean.class);
            return solicitanteBean.findSolicitanteById(id);
        } catch (NumberFormatException e) {
            LOGGER.severe("Error converting String to Solicitante: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Solicitante) {
            Solicitante solicitante = (Solicitante) value;
            String id = solicitante.getId() != null ? solicitante.getId().toString() : "";
            LOGGER.info("Converting Solicitante to String with ID: " + id);
            return id;
        } else {
            throw new IllegalArgumentException("Object " + value + " is not of type Solicitante");
        }
    }
}

