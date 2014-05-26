#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json

jsonobject = json.load(file('5365dee31bc6e9d9463a0057'))
jsonobject = json.dumps(jsonobject, ensure_ascii=False)

for jsonobjects in jsonobject:
  print jsonobject["總價元"]

