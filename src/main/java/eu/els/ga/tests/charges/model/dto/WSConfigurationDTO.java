package eu.els.ga.tests.charges.model.dto;

public class WSConfigurationDTO {
	
	private String version;
	private String artifactid;
	private String envName;
	private String mavenProfile;
	private String hibernateDdlAuto;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getArtifactid() {
		return artifactid;
	}
	public void setArtifactid(String artifactid) {
		this.artifactid = artifactid;
	}
	public String getEnvName() {
		return envName;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getMavenProfile() {
		return mavenProfile;
	}
	public void setMavenProfile(String mavenProfile) {
		this.mavenProfile = mavenProfile;
	}
	public String getHibernateDdlAuto() {
		return hibernateDdlAuto;
	}
	public void setHibernateDdlAuto(String hibernateDdlAuto) {
		this.hibernateDdlAuto = hibernateDdlAuto;
	}
}
