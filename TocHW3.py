#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json

jsonobject = json.dumps(file('5365dee31bc6e9d9463a0057'), ensure_ascii=False)
js = json.load(jsonobject)

for j in js:
  print j["總價元"]

