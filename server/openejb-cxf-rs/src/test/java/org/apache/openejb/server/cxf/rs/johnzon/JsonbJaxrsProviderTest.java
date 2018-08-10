/*
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
package org.apache.openejb.server.cxf.rs.johnzon;

import org.apache.johnzon.mapper.JohnzonIgnore;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.SingletonBean;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.loader.IO;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testing.RandomPort;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.json.bind.annotation.JsonbTransient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@EnableServices("jax-rs")
@RunWith(ApplicationComposer.class)
public class JsonbJaxrsProviderTest {
    @RandomPort("http")
    private URL base;

    @Module
    public EjbJar beans() {
        final EjbJar ejbJar = new EjbJar();
        ejbJar.addEnterpriseBean(new SingletonBean(Endpoint.class));
        return ejbJar;
    }

    @Test
    public void run() throws IOException {
        assertEquals("{\"value\":\"value\"}",
                     IO.slurp(new URL(base.toExternalForm() + getClass().getSimpleName() + "/test")));
    }

    @Path("test")
    public static class Endpoint {
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Model get() {
            final Model model = new Model();
            model.setValue("value");
            model.setIgnoreJohnzon("ignoreJohnzon");
            model.setIgnoreJsonb("ignoreJsonb");
            return model;
        }
    }

    public static class Model {
        private String value;
        @JohnzonIgnore
        private String ignoreJohnzon;
        @JsonbTransient
        private String ignoreJsonb;

        public String getValue() {
            return value;
        }

        public void setValue(final String value) {
            this.value = value;
        }

        public String getIgnoreJohnzon() {
            return ignoreJohnzon;
        }

        public void setIgnoreJohnzon(final String ignoreJohnzon) {
            this.ignoreJohnzon = ignoreJohnzon;
        }

        public String getIgnoreJsonb() {
            return ignoreJsonb;
        }

        public void setIgnoreJsonb(final String ignoreJsonb) {
            this.ignoreJsonb = ignoreJsonb;
        }
    }
}
