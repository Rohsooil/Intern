package food869.was.lib.container;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import food869.was.bin.CommonClassLoader;

public class Container {
	private DeployDescriptReader deployDescriptReader;
	private HashSet<File> webApps;
	private HashMap<String, String> urlMap;

	public Container() {
		urlMap = new HashMap<>();
		deployDescriptReader = new DeployDescriptReader();
		setWebApps();
	}

	private void setWebApps() {
		File rootDir = new File("../webapps/");
		webApps = new HashSet<File>(Arrays.asList(rootDir.listFiles()));
	}

	public void start(CommonClassLoader wasClassLoader) {

		if (!webApps.isEmpty()) {
			for (File webApp : webApps) {
				urlMap.putAll(deployDescriptReader.getAllUrlPatterns(webApp));
			}
		}

		new WebServer(wasClassLoader).runServer(urlMap);

	}

}
