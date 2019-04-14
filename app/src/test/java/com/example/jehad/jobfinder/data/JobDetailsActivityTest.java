package com.example.jehad.jobfinder.data;

import com.example.jehad.jobfinder.BuildConfig;
import com.example.jehad.jobfinder.data.model.job.GitHubJob;
import com.example.jehad.jobfinder.ui.details.JobDetailsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class JobDetailsActivityTest {
    private JobDetailsActivity jobDetailsActivity;
    private String urlTest = "https://www.usajobs.gov/GetJob/ViewDetails/515658500";
    private GitHubJob gitHubJob = new GitHubJob();

    @Before
    public void setUp() {

        gitHubJob.setUrl(urlTest);
        jobDetailsActivity = Robolectric.buildActivity(JobDetailsActivity.class, JobDetailsActivity.createIntent(RuntimeEnvironment.application, gitHubJob))
                .create()
                .start()
                .resume()
                .visible()
                .get();

    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(jobDetailsActivity);
    }

    @Test
    public void shouldHaveBaseJob() {
        assertEquals(jobDetailsActivity.getBaseJob(), gitHubJob);
    }

}
