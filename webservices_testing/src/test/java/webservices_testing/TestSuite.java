package webservices_testing;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import net.serenitybdd.jbehave.SerenityStories;
import webservices_testing.steps.MessangerGetSinglePostStepDefinition;

public class TestSuite extends SerenityStories{
	
	public TestSuite() {
		
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new MessangerGetSinglePostStepDefinition());
	}
	
	@Override
	public List<String> storyPaths(){
		return Arrays.asList("stories/messanger_get_single_post.story");
		
	}
	
	@Override
	public void run() throws Throwable{
		super.run();
	}
}
