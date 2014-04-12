■UbuntuへのOpenJTalkのインストール方法


build-essential は、インストールしておく。

hts_engine_API のインストール

open_jtalk のインストール

./configure --with-hts-engine-header-path=/usr/local/include --with-hts-engine-library-path=/usr/local/lib --with-charset=UTF-8

sudo mkdir /usr/local/share/hts
sudo cp nitech_jp_atr503_m001.htsvoice /usr/local/share/hts

sudo cp -r open_jtalk_dic_utf_8-1.07 /usr/local/share/hts/open_jtalk_dic_utf_8


動作テスト

echo "こんにちは" > infile.txt

open_jtalk -x /usr/local/share/hts/open_jtalk_dic_utf_8 -m /usr/local/share/hts/nitech_jp_atr503_m001.htsvoice -ow out.wav infile.txt


aplay out.wav





open_jtalk - The Japanese TTS system "Open JTalk"

  usage:
       open_jtalk [ options ] [ infile ] 
  options:                                                                   [  def][ min-- max]
    -x  dir        : dictionary directory                                    [  N/A]
    -m  htsvoice   : HTS voice files                                         [  N/A]
    -ow s          : filename of output wav audio (generated speech)         [  N/A]
    -ot s          : filename of output trace information                    [  N/A]
    -s  i          : sampling frequency                                      [ auto][   1--    ]
    -p  i          : frame period (point)                                    [ auto][   1--    ]
    -a  f          : all-pass constant                                       [ auto][ 0.0-- 1.0]
    -b  f          : postfiltering coefficient                               [  0.0][ 0.0-- 1.0]
    -r  f          : speech speed rate                                       [  1.0][ 0.0--    ]
    -fm f          : additional half-tone                                    [  0.0][    --    ]
    -u  f          : voiced/unvoiced threshold                               [  0.5][ 0.0-- 1.0]
    -jm f          : weight of GV for spectrum                               [  1.0][ 0.0--    ]
    -jf f          : weight of GV for log F0                                 [  1.0][ 0.0--    ]
    -z  i          : audio buffer size (if i==0, turn off)                   [    0][   0--    ]
  infile:
    text file                                                                [stdin]
