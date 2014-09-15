package com.pampanet.sample.shiro.modules;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.Singleton;

/**
 * This Module loads a Sample IniRealm. This is also a Guice's PrivateModule.<br> 
 * For injecting any of the providers listed here, you need to expose them through configureShiroWeb() method.<br>
 * 
 * 
 * @author pablo.biagioli
 *
 */
public class BootstrapShiroModule extends ShiroWebModule{
	
	private static final String CREDENTIALS_MATCHER_ALGORITHM_NAME = "SHA-512";

	public BootstrapShiroModule(ServletContext servletContext) {
		super(servletContext);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void configureShiroWeb() {
		//if you would like to expose the CredentialsMatcher listed here, uncomment the following line.
		//expose(CredentialsMatcher.class);
		try {
            bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
        } catch (NoSuchMethodException e) {
            addError(e);
        }
		Key<MyHttpAuthFilter> authcBasic =  Key.get(MyHttpAuthFilter.class);
		addFilterChain("/logout", LOGOUT);
        addFilterChain("/**", config(authcBasic,AuthenticatingFilter.PERMISSIVE));
        
	}

	@Provides
	@Singleton
    Ini loadShiroIni() {
		Ini result = Ini.fromResourcePath("classpath:shiro.ini"); 
        return result;
    }
	
	public static class MyHttpAuthFilter extends BasicHttpAuthenticationFilter{
		@Override
		protected boolean onAccessDenied(ServletRequest request,
				ServletResponse response) throws Exception {
			HttpServletResponse result = (HttpServletResponse) response;
			
			result.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = result.getWriter();
	        out.print("Don't have enough permissions to access this resource");
	        result.setStatus(Status.UNAUTHORIZED.getStatusCode());
	        
			return false;
		}
	}
	
	/**
	 * When annotations activated, you'll need to hash passwords in your configured Realm (i.e.: shiro.ini file)
	 * @return credentialsMatcher singleton implementation for this application
	 */
	//@Provides
	//@Singleton
	public CredentialsMatcher provideCredentialsMatcher(){
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName(CREDENTIALS_MATCHER_ALGORITHM_NAME);
		return matcher;
	}
	
}
