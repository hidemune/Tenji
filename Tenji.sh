#/bin/bash

java -jar ./dist/Tenji.jar &

#Open JTalk
infile=openjtalk_infile.txt

while (true)
do
  if [ -f ${infile} ] ; then

/usr/local/bin/open_jtalk -x /usr/local/share/hts/open_jtalk_dic_utf_8 -m /usr/local/share/hts/nitech_jp_atr503_m001.htsvoice -ow out.wav ${infile}

/usr/bin/aplay out.wav

rm ${infile}

  fi
done
