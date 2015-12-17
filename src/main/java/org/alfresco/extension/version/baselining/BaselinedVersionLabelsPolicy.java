package org.alfresco.extension.version.baselining;

import java.io.Serializable;
import java.util.Map;

import org.alfresco.repo.version.VersionServicePolicies.CalculateVersionLabelPolicy;
import org.alfresco.repo.version.common.versionlabel.SerialVersionLabelPolicy;
import org.alfresco.service.cmr.version.Version;
import org.alfresco.service.namespace.QName;

public class BaselinedVersionLabelsPolicy implements CalculateVersionLabelPolicy
{
	private final SerialVersionLabelPolicy defaultPolicy = new SerialVersionLabelPolicy();
	private String baseVersion = "0.1";
	
	public void setBaseVersion(String baseVersion)
	{
		this.baseVersion = baseVersion;
	}

	

	@Override
	public String calculateVersionLabel(final QName                     classRef,
            final Version                   preceedingVersion,
            final int                       versionNumber,
            final Map<String, Serializable> versionProperties)
	{
		String result=null;
		if (preceedingVersion == null)
        {
			result=baseVersion;
	    }else{
        	result=defaultPolicy.calculateVersionLabel(classRef, preceedingVersion, versionNumber, versionProperties);
        }
		return result;
	}


}
