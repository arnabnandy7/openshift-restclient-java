/*******************************************************************************
 * Copyright (c) 2015 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/

package com.openshift.internal.restclient.capability.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.openshift.restclient.IClient;
import com.openshift.restclient.ResourceKind;
import com.openshift.restclient.model.IResource;

@RunWith(MockitoJUnitRunner.class)
public class TemplateTraceabilityTest {

    private TemplateTraceability capability;
    @Mock
    private IClient client;
    @Mock
    private IResource resource;

    @Before
    public void setUp() {
        capability = new TemplateTraceability(resource);
        lenient().when(resource.getNamespaceName()).thenReturn("mynamespace");
        lenient().when(resource.getKind()).thenReturn(ResourceKind.TEMPLATE);
    }

    @Test
    public void supportedWhenAnnotationHasTemplateKey() {
        when(resource.isAnnotatedWith("template")).thenReturn(true);
        when(resource.getAnnotation("template")).thenReturn("aTemplateName");

        assertTrue("Exp. the capability to be supported because it has the template annotation",
                capability.isSupported());
        assertEquals("Exp. to get the template name", "aTemplateName", capability.getTemplateName());
    }

    @Test
    public void unsupportedWhenAnnotationDoesNotHasTemplateKey() {
        assertFalse("Exp. the capability to not be supported because it does not have the template annotation",
                capability.isSupported());
        assertEquals("Exp. to get the template name", "", capability.getTemplateName());
    }

    @Test
    public void testGetName() {
        assertEquals("", TemplateTraceability.class.getSimpleName(), capability.getName());
    }
}
