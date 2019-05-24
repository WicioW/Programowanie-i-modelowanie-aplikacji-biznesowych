package restApi.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;

public class MyCors extends CorsConfiguration{
	private List<String> allowedOrigins;
	private List<String> allowedMethods;

	private List<HttpMethod> resolvedMethods = DEFAULT_METHODS;

	private List<String> allowedHeaders;

	private List<String> exposedHeaders;

	private Boolean allowCredentials;

	private Long maxAge;
	
	
	
	public MyCors() {
	}
	
	private static final List<HttpMethod> DEFAULT_METHODS;
	static {
		List<HttpMethod> rawMethods = new ArrayList<HttpMethod>(2);
		rawMethods.add(HttpMethod.GET);
		rawMethods.add(HttpMethod.HEAD);
		DEFAULT_METHODS = Collections.unmodifiableList(rawMethods);
	}
	
	/*
	 * Overrided method- add delete.name method
	 * for our cors needs.
	 */
	
	@Override
	public CorsConfiguration applyPermitDefaultValues() {
		if (this.allowedOrigins == null) {
			this.addAllowedOrigin(ALL);
		}
		if (this.allowedMethods == null) {
			this.setAllowedMethods(Arrays.asList(
					HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.DELETE.name()));
		}
		if (this.allowedHeaders == null) {
			this.addAllowedHeader(ALL);
		}
		if (this.allowCredentials == null) {
			this.setAllowCredentials(true);
		}
		if (this.maxAge == null) {
			this.setMaxAge(1800L);
		}
		return this;
	}
}
