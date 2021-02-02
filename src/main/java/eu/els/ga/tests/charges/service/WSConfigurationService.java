package eu.els.ga.tests.charges.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import eu.els.ga.tests.charges.model.dto.WSConfigurationDTO;
import eu.els.ga.tests.charges.model.dto.WSVersionDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class WSConfigurationService {

	@Value("${build.version}")
	private String version;

	@Value("${application.name}")
	private String artifactid;

	@Value("${envName}")
	private String envName;

	@Value("${spring.profiles.active}")
	private String mavenProfile;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateDdlAuto;

	private String getVersion() {
		return version;
	}

	public String getEnvName() {
		return envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getArtifactid() {
		return artifactid;
	}

	public void setArtifactid(String artifactid) {
		this.artifactid = artifactid;
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

	public void setVersion(String version) {
		this.version = version;
	}

	public WSConfigurationDTO getConfiguration() {

		WSConfigurationDTO configurationDTO = new WSConfigurationDTO();
		configurationDTO.setVersion(getVersion());
		configurationDTO.setArtifactid(getArtifactid());
		configurationDTO.setEnvName(getEnvName());
		configurationDTO.setMavenProfile(getMavenProfile());
		configurationDTO.setHibernateDdlAuto(getHibernateDdlAuto());
		return configurationDTO;
	}

	public WSVersionDTO getWSVersion() {

		WSVersionDTO wsVersion = new WSVersionDTO();
		wsVersion.setVersion(getVersion());

		return wsVersion;
	}

}
