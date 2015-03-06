package com.ullink.slack.simpleslackapi.impl;

import com.ullink.slack.simpleslackapi.SlackAttachment;
import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackMessageHandle;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class TestAbstractSlackSessionImpl
{

    private class TestSlackSessionImpl extends AbstractSlackSessionImpl
    {

        @Override
        public void connect()
        {
            channels.put("channelid1",new SlackChannelImpl("channelid1", "testchannel1", "topicchannel1", "topicchannel1"));
            channels.put("channelid2",new SlackChannelImpl("channelid2", "testchannel2", "topicchannel2", "topicchannel2"));
            channels.put("channelid3",new SlackChannelImpl("channelid3", "testchannel3", "topicchannel3", "topicchannel3"));
            channels.put("channelid4",new SlackChannelImpl("channelid4", "testchannel4", "topicchannel4", "topicchannel4"));
            channels.put("channelid5",new SlackChannelImpl("channelid5", "testchannel5", "topicchannel5", "topicchannel5"));

            users.put("userid1",new SlackUserImpl("userid1", "username1", "realname1","userid1@my.mail", false));
            users.put("userid2",new SlackUserImpl("userid2", "username2", "realname2","userid2@my.mail", false));
            users.put("userid3",new SlackUserImpl("userid3", "username3", "realname3","userid3@my.mail", true));
            users.put("userid4",new SlackUserImpl("userid4", "username4", "realname4","userid4@my.mail", false));
            users.put("userid5",new SlackUserImpl("userid5", "username5", "realname4","userid5@my.mail", true));

            bots.put("botid1",new SlackBotImpl("botid1", "botname1", false));
            bots.put("botid2",new SlackBotImpl("botid2", "botname2", false));
            bots.put("botid3",new SlackBotImpl("botid3", "botname2", true));

        }

        @Override
        public SlackMessageHandle sendMessage(SlackChannel channel, String message, SlackAttachment attachment, String username, String iconURL)
        {
            return null;
        }

        @Override
        public SlackMessageHandle sendMessageOverWebSocket(SlackChannel channel, String message, SlackAttachment attachment)
        {
            return null;
        }

        @Override
        public SlackMessageHandle deleteMessage(String timeStamp, SlackChannel channel)
        {
            return null;
        }

        @Override
        public SlackMessageHandle updateMessage(String timeStamp, SlackChannel channel, String message)
        {
            return null;
        }
    }

    @Test
    public void testFindChannelByName_ExistingChannel()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findChannelByName("testchannel1")).isNotNull();
        assertThat(slackSession.findChannelByName("testchannel1").getId()).isEqualTo("channelid1");
    }

    @Test
    public void testFindChannelByName_MissingChannel()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findChannelByName("unknownChannel")).isNull();
    }

    @Test
    public void testFindChannelById_ExistingChannel()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findChannelById("channelid1")).isNotNull();
        assertThat(slackSession.findChannelById("channelid1").getName()).isEqualTo("testchannel1");
    }

    @Test
    public void testFindChannelById_MissingChannel()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findChannelByName("unknownChannel")).isNull();
    }

    @Test
    public void testFindBotById_ExistingBot()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findBotById("botid1")).isNotNull();
        assertThat(slackSession.findBotById("botid1").getName()).isEqualTo("botname1");
    }

    @Test
    public void testFindBotById_MissingBot()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findBotById("unknownbot")).isNull();
    }

    @Test
    public void testFindUserById_ExistingBot()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findUserById("userid1")).isNotNull();
        assertThat(slackSession.findUserById("userid1").getUserName()).isEqualTo("username1");
    }

    @Test
    public void testFindUserById_MissingBot()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findBotById("unknownuser")).isNull();
    }

    @Test
    public void testFindUserByUserName_ExistingBot()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findUserByUserName("username1")).isNotNull();
        assertThat(slackSession.findUserByUserName("username1").getId()).isEqualTo("userid1");
    }

    @Test
    public void testFindUserByUserName_MissingBot()
    {
        TestSlackSessionImpl slackSession = new TestSlackSessionImpl();

        slackSession.connect();

        assertThat(slackSession.findUserByUserName("unknownuser")).isNull();
    }


}