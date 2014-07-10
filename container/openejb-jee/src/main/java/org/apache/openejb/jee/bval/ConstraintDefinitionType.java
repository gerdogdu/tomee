/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.openejb.jee.bval;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for constraint-definitionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="constraint-definitionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="validated-by" type="{http://jboss.org/xml/ns/javax/validation/mapping}validated-byType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="annotation" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "constraint-definitionType", propOrder = {
    "validatedBy"
})
public class ConstraintDefinitionType {

    @XmlElement(name = "validated-by", required = true)
    protected ValidatedByType validatedBy;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String annotation;

    /**
     * Gets the value of the validatedBy property.
     *
     * @return possible object is
     * {@link ValidatedByType }
     */
    public ValidatedByType getValidatedBy() {
        return validatedBy;
    }

    /**
     * Sets the value of the validatedBy property.
     *
     * @param value allowed object is
     *              {@link ValidatedByType }
     */
    public void setValidatedBy(final ValidatedByType value) {
        this.validatedBy = value;
    }

    /**
     * Gets the value of the annotation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAnnotation(final String value) {
        this.annotation = value;
    }

}
