package eu.els.ga.tests.charges.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.els.ga.tests.charges.model.dto.WSConfigurationDTO;
import eu.els.ga.tests.charges.repository.exception.BussinesException;
import eu.els.ga.tests.charges.service.WSConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/configuration")
public class WSConfigurationAPI extends AbstractAPI {
	private final WSConfigurationService configurationService;

	@GetMapping("/")
	public ResponseEntity<WSConfigurationDTO> getConfiguration() throws BussinesException {
		try {
			return ResponseEntity.ok(configurationService.getConfiguration());

		} catch (Exception e) {
			throw new BussinesException(WS_CONFIGURATION_ERROR_CODE, "problème de la récupération de la configuration");
		}
	}
}
