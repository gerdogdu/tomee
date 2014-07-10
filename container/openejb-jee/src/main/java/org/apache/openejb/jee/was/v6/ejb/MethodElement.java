/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.openejb.jee.was.v6.ejb;

import org.apache.openejb.jee.was.v6.common.Description;
import org.apache.openejb.jee.was.v6.xmi.Extension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

/**
 * The method element is used to denote a method of an enterprise bean's home or
 * remote interface, or a set of methods. The ejb-name element must be the name
 * of one of the enterprise beans in declared in the deployment descriptor; the
 * optional method-intf element allows to distinguish between a method with the
 * same signature that is defined in both the home and remote interface; the
 * method-name element specifies the method name; and the optional method-params
 * elements identify a
 * <p/>
 * single method among multiple methods with an overloaded method name.
 * <p/>
 * There are three possible styles of the method element syntax:
 * <p/>
 * 1. <method>
 * <p/>
 * <ejb-name>EJBNAME</ejb-name>
 * <p/>
 * <method-name>*</method-name>
 * <p/>
 * </method>
 * <p/>
 * <p/>
 * This style is used to refer to all the methods of the specified enterprise
 * bean's home and remote interfaces.
 * <p/>
 * <p/>
 * 2. <method>
 * <p/>
 * <ejb-name>EJBNAME</ejb-name>
 * <p/>
 * <method-name>METHOD</method-name>
 * <p/>
 * </method>>
 * <p/>
 * This style is used to refer to the specified method of the specified
 * enterprise bean. If there are multiple methods with
 * <p/>
 * the same overloaded name, the element of this style refers to all the methods
 * with the overloaded name.
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * 3. <method>
 * <p/>
 * <ejb-name>EJBNAME</ejb-name>
 * <p/>
 * <method-name>METHOD</method-name>
 * <p/>
 * <method-params>
 * <p/>
 * <method-param>PARAM-1</method-param>
 * <p/>
 * <method-param>PARAM-2</method-param>
 * <p/>
 * ...
 * <p/>
 * <method-param>PARAM-n</method-param>
 * <p/>
 * </method-params> <method>
 * <p/>
 * <p/>
 * This style is used to refer to a single method within a set of methods with
 * an overloaded name. PARAM-1 through PARAM-n are the fully-qualified Java
 * types of the method's input parameters (if the method has no input arguments,
 * the method-params element
 * <p/>
 * contains no method-param elements). Arrays are specified by the array
 * element's type, followed by one or more pair of square brackets (e.g.
 * int[][]).
 * <p/>
 * <p/>
 * <p/>
 * Used in: method-permission and container-transaction
 * <p/>
 * Examples:
 * <p/>
 * <p/>
 * Style 1: The following method element refers to all the methods of the
 * EmployeeService bean's home and remote interfaces:
 * <p/>
 * <p/>
 * <method>
 * <p/>
 * <ejb-name>EmployeeService</ejb-name>
 * <p/>
 * <method-name>*</method-name>
 * <p/>
 * </method>
 * <p/>
 * <p/>
 * Style 2: The following method element refers to all the create methods of the
 * EmployeeService bean's home interface:
 * <p/>
 * <p/>
 * <method>
 * <p/>
 * <ejb-name>EmployeeService</ejb-name>
 * <p/>
 * <method-name>create</method-name>
 * <p/>
 * </method>
 * <p/>
 * Style 3: The following method element refers to the create(String firstName,
 * String LastName) method of the EmployeeService bean's home interface.
 * <p/>
 * <p/>
 * <method>
 * <p/>
 * <ejb-name>EmployeeService</ejb-name>
 * <p/>
 * <method-name>create</method-name>
 * <p/>
 * <method-params>
 * <p/>
 * <method-param>java.lang.String</method-param>
 * <p/>
 * <method-param>java.lang.String</method-param>
 * <p/>
 * </method-params> </method>
 * <p/>
 * <p/>
 * <p/>
 * The following example illustrates a Style 3 element with more complex
 * parameter types. The method foobar(char s, int i, int[] iar,
 * mypackage.MyClass mycl, mypackage.MyClass[][] myclaar)
 * <p/>
 * would be specified as:
 * <p/>
 * <p/>
 * <method>
 * <p/>
 * <ejb-name>EmployeeService</ejb-name>
 * <p/>
 * <method-name>foobar</method-name>
 * <p/>
 * <method-params>
 * <p/>
 * <method-param>char</method-param>
 * <p/>
 * <method-param>int</method-param>
 * <p/>
 * <method-param>int[]</method-param>
 * <p/>
 * <method-param>mypackage.MyClass</method-param>
 * <p/>
 * <method-param>mypackage.MyClass[][]</method-param>
 * <p/>
 * </method-params> </method>
 * <p/>
 * <p/>
 * The optional method-intf element can be used when it becomes necessary to
 * differentiate between a method defined in the home interface and a method
 * with the same name and signature that is defined in the remote interface.
 * <p/>
 * For example, the method element
 * <p/>
 * <p/>
 * <method>
 * <p/>
 * <ejb-name>EmployeeService</ejb-name>
 * <p/>
 * <method-intf>Remote</method-intf>
 * <p/>
 * <method-name>create</method-name>
 * <p/>
 * <method-params>
 * <p/>
 * <method-param>java.lang.String</method-param>
 * <p/>
 * <method-param>java.lang.String</method-param>
 * <p/>
 * </method-params> </method>
 * <p/>
 * <p/>
 * can be used to differentiate the create(String, String) method defined in the
 * remote interface from the create(String, String) method defined in the home
 * interface, which would be defined as
 * <p/>
 * <p/>
 * <method>
 * <p/>
 * <ejb-name>EmployeeService</ejb-name>
 * <p/>
 * <method-intf>Home</method-intf>
 * <p/>
 * <method-name>create</method-name>
 * <p/>
 * <method-params>
 * <p/>
 * <method-param>java.lang.String</method-param>
 * <p/>
 * <method-param>java.lang.String</method-param>
 * <p/>
 * </method-params> </method>
 * <p/>
 * <p/>
 * <p/>
 * Java class for MethodElement complex type.
 * <p/>
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MethodElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="enterpriseBean" type="{ejb.xmi}EnterpriseBean"/>
 *         &lt;/choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="descriptions" type="{common.xmi}Description"/>
 *         &lt;/choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.omg.org/XMI}Extension"/>
 *         &lt;/choice>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.omg.org/XMI}ObjectAttribs"/>
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="enterpriseBean" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="parms" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{ejb.xmi}MethodElementKind" />
 *       &lt;attribute ref="{http://www.omg.org/XMI}id"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodElement", propOrder = {"enterpriseBeans",
    "descriptions", "extensions"})
public class MethodElement {

    @XmlElement(name = "enterpriseBean")
    protected List<EnterpriseBean> enterpriseBeans;
    protected List<Description> descriptions;
    @XmlElement(name = "Extension", namespace = "http://www.omg.org/XMI")
    protected List<Extension> extensions;
    @XmlAttribute
    protected String description;
    @XmlAttribute
    protected String enterpriseBean;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected String parms;
    @XmlAttribute(name = "type")
    protected MethodElementEnum methodElementType;
    @XmlAttribute(namespace = "http://www.omg.org/XMI")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute(namespace = "http://www.omg.org/XMI")
    protected QName type;
    @XmlAttribute(namespace = "http://www.omg.org/XMI")
    protected String version;
    @XmlAttribute
    protected String href;
    @XmlAttribute(namespace = "http://www.omg.org/XMI")
    @XmlIDREF
    protected Object idref;
    @XmlAttribute(namespace = "http://www.omg.org/XMI")
    protected String label;
    @XmlAttribute(namespace = "http://www.omg.org/XMI")
    protected String uuid;

    /**
     * Gets the value of the enterpriseBeans property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the enterpriseBeans property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <p/>
     * <pre>
     * getEnterpriseBeans().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link EnterpriseBean }
     */
    public List<EnterpriseBean> getEnterpriseBeans() {
        if (enterpriseBeans == null) {
            enterpriseBeans = new ArrayList<EnterpriseBean>();
        }
        return this.enterpriseBeans;
    }

    /**
     * Gets the value of the descriptions property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the descriptions property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <p/>
     * <pre>
     * getDescriptions().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Description }
     */
    public List<Description> getDescriptions() {
        if (descriptions == null) {
            descriptions = new ArrayList<Description>();
        }
        return this.descriptions;
    }

    /**
     * Gets the value of the extensions property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the extensions property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <p/>
     * <pre>
     * getExtensions().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Extension }
     */
    public List<Extension> getExtensions() {
        if (extensions == null) {
            extensions = new ArrayList<Extension>();
        }
        return this.extensions;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDescription(final String value) {
        this.description = value;
    }

    /**
     * Gets the value of the enterpriseBean property.
     *
     * @return possible object is {@link String }
     */
    public String getEnterpriseBean() {
        return enterpriseBean;
    }

    /**
     * Sets the value of the enterpriseBean property.
     *
     * @param value allowed object is {@link String }
     */
    public void setEnterpriseBean(final String value) {
        this.enterpriseBean = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Gets the value of the parms property.
     *
     * @return possible object is {@link String }
     */
    public String getParms() {
        return parms;
    }

    /**
     * Sets the value of the parms property.
     *
     * @param value allowed object is {@link String }
     */
    public void setParms(final String value) {
        this.parms = value;
    }

    /**
     * Gets the value of the methodElementType property.
     *
     * @return possible object is {@link MethodElementEnum }
     */
    public MethodElementEnum getMethodElementType() {
        return methodElementType;
    }

    /**
     * Sets the value of the methodElementType property.
     *
     * @param value allowed object is {@link MethodElementEnum }
     */
    public void setMethodElementType(final MethodElementEnum value) {
        this.methodElementType = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link String }
     */
    public void setId(final String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is {@link QName }
     */
    public QName getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is {@link QName }
     */
    public void setType(final QName value) {
        this.type = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is {@link String }
     */
    public String getVersion() {
        if (version == null) {
            return "2.0";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is {@link String }
     */
    public void setVersion(final String value) {
        this.version = value;
    }

    /**
     * Gets the value of the href property.
     *
     * @return possible object is {@link String }
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     *
     * @param value allowed object is {@link String }
     */
    public void setHref(final String value) {
        this.href = value;
    }

    /**
     * Gets the value of the idref property.
     *
     * @return possible object is {@link Object }
     */
    public Object getIdref() {
        return idref;
    }

    /**
     * Sets the value of the idref property.
     *
     * @param value allowed object is {@link Object }
     */
    public void setIdref(final Object value) {
        this.idref = value;
    }

    /**
     * Gets the value of the label property.
     *
     * @return possible object is {@link String }
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     *
     * @param value allowed object is {@link String }
     */
    public void setLabel(final String value) {
        this.label = value;
    }

    /**
     * Gets the value of the uuid property.
     *
     * @return possible object is {@link String }
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     *
     * @param value allowed object is {@link String }
     */
    public void setUuid(final String value) {
        this.uuid = value;
    }

}
