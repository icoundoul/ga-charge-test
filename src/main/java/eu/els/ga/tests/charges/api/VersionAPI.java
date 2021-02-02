package eu.els.ga.tests.charges.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.els.ga.tests.charges.model.dto.WSVersionDTO;
import eu.els.ga.tests.charges.repository.exception.BussinesException;
import eu.els.ga.tests.charges.service.WSConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/version")
public class VersionAPI extends AbstractAPI {
	private final WSConfigurationService configurationService;

	@GetMapping("/")
	public ResponseEntity<WSVersionDTO> getVersion() throws BussinesException {
		try {
			return ResponseEntity.ok(configurationService.getWSVersion());
		} catch (Exception e) {
			throw new BussinesException(WS_VERSION_ERROR_CODE, "problème de la récupération de la version");
		}
	}

}
