/*******************************************************************************
 * Copyright (c) 2015-2019 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package com.openshift.internal.restclient.model.volume.property;

import org.jboss.dmr.ModelNode;

import com.openshift.restclient.model.volume.property.IPersistentVolumeProperties;

public interface ISettablePersistentVolumeProperties extends IPersistentVolumeProperties {

    void setProperties(ModelNode node);

}
