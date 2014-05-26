package com.lejingw.apps.xunfeivoice;

import java.util.ArrayList;
import java.util.List;

import com.iflytek.speech.RecognizerListener;
import com.iflytek.speech.RecognizerResult;
import com.iflytek.speech.SpeechError;
import com.iflytek.speech.SpeechRecognizer;
import com.iflytek.speech.SynthesizerPlayer;
import com.iflytek.speech.SynthesizerPlayerListener;

public class Snippet {
	public void test1() {
		// 创建SpeechRecognizer对象，appid通过http://open.voicecloud.cn站点申请
		// 详细内容请参考sample代码
		SpeechRecognizer recognizer = SpeechRecognizer
				.createRecognizer("appid=******");

		// 转写监听器
		RecognizerListener mRecoListener = new RecognizerListener() {
			// 识别结果回调接口
			public void onResults(ArrayList results, boolean isLast) {
				List<RecognizerResult> list = (List<RecognizerResult>) results;
				String text = "";
				// 一般情况下会通过onResults接口多次返回结果，完整的识别内容是多次结果的累加.
				for (int i = 0; i < list.size(); i++) {
					RecognizerResult rr = list.get(i);
					text += rr.text;
				}
			}

			// 会话结束回调接口.
			public void onEnd(SpeechError error) {
				// error为null表示会话成功，可在此处理text结果，error不为null，表示发生错
			}

			// 开始录音
			public void onBeginOfSpeech() {
			}

			// 音量值0~10
			public void onVolumeChanged(int arg0) {
			}

			// 结束录音
			public void onEndOfSpeech() {
			}

			@Override
			public void onCancel() {

			}
		};
		recognizer.startListening(mRecoListener, "sms", null, null);
	}

	public void test2() {
		// 创建SynthesizerPlayer对象，appid通过http://open.voicecloud.cn站点申请
		SynthesizerPlayer player = SynthesizerPlayer
				.createSynthesizerPlayer("appid=12345678");
		player.setVoiceName("xiaoyu");
		SynthesizerPlayerListener mSynListener = new SynthesizerPlayerListener() {
			// 会话结束回调接口.
			public void onEnd(SpeechError error) {
				// error为null表示会话成功， error不为null，表示发生错误
			}

			// 缓冲进度回调
			public void onBufferPercent(int arg0, int arg1, int arg2) {
				// arg0为缓冲进度0~100，arg1为缓冲音频在文本中开始位置，arg2表示缓冲音频在文本中结束位置.
			}

			// 开始播放
			public void onPlayBegin() {
			}

			// 暂停播放
			public void onPlayPaused() {
			}

			// 播放进度回调
			public void onPlayPercent(int arg0, int arg1, int arg2) {
				// arg0为播放进度0~100,arg1为播放音频在文本中开始位置，arg2表示播放音频在文本中结束位置.
			}

			// 恢复播放回调接口
			public void onPlayResumed() {
			}

			@Override
			public void onBufferPercent(int arg0, int arg1, int arg2, String arg3) {
			}
		};
		player.playText("安徽科大讯飞信息科技股份有限公司", " tts_buffer_time=5000", mSynListener);
	}
}
