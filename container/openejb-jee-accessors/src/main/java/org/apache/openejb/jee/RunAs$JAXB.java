/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.openejb.jee;

import java.util.ArrayList;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import org.metatype.sxc.jaxb.JAXBObject;
import org.metatype.sxc.jaxb.LifecycleCallback;
import org.metatype.sxc.jaxb.RuntimeContext;
import org.metatype.sxc.util.Attribute;
import org.metatype.sxc.util.XoXMLStreamReader;
import org.metatype.sxc.util.XoXMLStreamWriter;


import static org.apache.openejb.jee.Text$JAXB.readText;
import static org.apache.openejb.jee.Text$JAXB.writeText;

@SuppressWarnings({
    "StringEquality"
})
public class RunAs$JAXB
    extends JAXBObject<RunAs>
{


    public RunAs$JAXB() {
        super(RunAs.class, null, new QName("http://java.sun.com/xml/ns/javaee".intern(), "run-asType".intern()), Text$JAXB.class);
    }

    public static RunAs readRunAs(XoXMLStreamReader reader, RuntimeContext context)
        throws Exception
    {
        return _read(reader, context);
    }

    public static void writeRunAs(XoXMLStreamWriter writer, RunAs runAs, RuntimeContext context)
        throws Exception
    {
        _write(writer, runAs, context);
    }

    public void write(XoXMLStreamWriter writer, RunAs runAs, RuntimeContext context)
        throws Exception
    {
        _write(writer, runAs, context);
    }

    public static final RunAs _read(XoXMLStreamReader reader, RuntimeContext context)
        throws Exception
    {

        // Check for xsi:nil
        if (reader.isXsiNil()) {
            return null;
        }

        if (context == null) {
            context = new RuntimeContext();
        }

        RunAs runAs = new RunAs();
        context.beforeUnmarshal(runAs, LifecycleCallback.NONE);

        ArrayList<Text> descriptions = null;

        // Check xsi:type
        QName xsiType = reader.getXsiType();
        if (xsiType!= null) {
            if (("run-asType"!= xsiType.getLocalPart())||("http://java.sun.com/xml/ns/javaee"!= xsiType.getNamespaceURI())) {
                return context.unexpectedXsiType(reader, RunAs.class);
            }
        }

        // Read attributes
        for (Attribute attribute: reader.getAttributes()) {
            if (("id" == attribute.getLocalName())&&(("" == attribute.getNamespace())||(attribute.getNamespace() == null))) {
                // ATTRIBUTE: id
                String id = Adapters.collapsedStringAdapterAdapter.unmarshal(attribute.getValue());
                context.addXmlId(reader, id, runAs);
                runAs.id = id;
            } else if (XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI!= attribute.getNamespace()) {
                context.unexpectedAttribute(attribute, new QName("", "id"));
            }
        }

        // Read elements
        for (XoXMLStreamReader elementReader: reader.getChildElements()) {
            if (("description" == elementReader.getLocalName())&&("http://java.sun.com/xml/ns/javaee" == elementReader.getNamespaceURI())) {
                // ELEMENT: descriptions
                Text descriptionsItem = readText(elementReader, context);
                if (descriptions == null) {
                    descriptions = new ArrayList<>();
                }
                descriptions.add(descriptionsItem);
            } else if (("role-name" == elementReader.getLocalName())&&("http://java.sun.com/xml/ns/javaee" == elementReader.getNamespaceURI())) {
                // ELEMENT: roleName
                String roleNameRaw = elementReader.getElementText();

                String roleName;
                try {
                    roleName = Adapters.collapsedStringAdapterAdapter.unmarshal(roleNameRaw);
                } catch (Exception e) {
                    context.xmlAdapterError(elementReader, CollapsedStringAdapter.class, String.class, String.class, e);
                    continue;
                }

                runAs.roleName = roleName;
            } else {
                context.unexpectedElement(elementReader, new QName("http://java.sun.com/xml/ns/javaee", "description"), new QName("http://java.sun.com/xml/ns/javaee", "role-name"));
            }
        }
        if (descriptions!= null) {
            try {
                runAs.setDescriptions(descriptions.toArray(new Text[descriptions.size()] ));
            } catch (Exception e) {
                context.setterError(reader, RunAs.class, "setDescriptions", Text[].class, e);
            }
        }

        context.afterUnmarshal(runAs, LifecycleCallback.NONE);

        return runAs;
    }

    public final RunAs read(XoXMLStreamReader reader, RuntimeContext context)
        throws Exception
    {
        return _read(reader, context);
    }

    public static final void _write(XoXMLStreamWriter writer, RunAs runAs, RuntimeContext context)
        throws Exception
    {
        if (runAs == null) {
            writer.writeXsiNil();
            return ;
        }

        if (context == null) {
            context = new RuntimeContext();
        }

        String prefix = writer.getUniquePrefix("http://java.sun.com/xml/ns/javaee");
        if (RunAs.class!= runAs.getClass()) {
            context.unexpectedSubclass(writer, runAs, RunAs.class);
            return ;
        }

        context.beforeMarshal(runAs, LifecycleCallback.NONE);


        // ATTRIBUTE: id
        String idRaw = runAs.id;
        if (idRaw!= null) {
            String id = null;
            try {
                id = Adapters.collapsedStringAdapterAdapter.marshal(idRaw);
            } catch (Exception e) {
                context.xmlAdapterError(runAs, "id", CollapsedStringAdapter.class, String.class, String.class, e);
            }
            writer.writeAttribute("", "", "id", id);
        }

        // ELEMENT: descriptions
        Text[] descriptions = null;
        try {
            descriptions = runAs.getDescriptions();
        } catch (Exception e) {
            context.getterError(runAs, "descriptions", RunAs.class, "getDescriptions", e);
        }
        if (descriptions!= null) {
            for (Text descriptionsItem: descriptions) {
                if (descriptionsItem!= null) {
                    writer.writeStartElement(prefix, "description", "http://java.sun.com/xml/ns/javaee");
                    writeText(writer, descriptionsItem, context);
                    writer.writeEndElement();
                } else {
                    context.unexpectedNullValue(runAs, "descriptions");
                }
            }
        }

        // ELEMENT: roleName
        String roleNameRaw = runAs.roleName;
        String roleName = null;
        try {
            roleName = Adapters.collapsedStringAdapterAdapter.marshal(roleNameRaw);
        } catch (Exception e) {
            context.xmlAdapterError(runAs, "roleName", CollapsedStringAdapter.class, String.class, String.class, e);
        }
        if (roleName!= null) {
            writer.writeStartElement(prefix, "role-name", "http://java.sun.com/xml/ns/javaee");
            writer.writeCharacters(roleName);
            writer.writeEndElement();
        } else {
            context.unexpectedNullValue(runAs, "roleName");
        }

        context.afterMarshal(runAs, LifecycleCallback.NONE);
    }

}
