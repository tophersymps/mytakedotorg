/*
 * MyTake.org website and tooling.
 * Copyright (C) 2017-2020 MyTake.org, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * You can contact us at team@mytake.org
 */
import { CaptionNodeArr, FoundationNode } from "../common/CaptionNodes";
import { TakeDocument } from "../components/BlockEditor";
import { Card } from "../components/FeedList";
import { TimelineItemData } from "../components/Timeline";
import { StylesObject, TimeRange } from "../components/Video";
import { FT } from "../java2ts/FT";

const videoFactFast: FT.VideoFactContent = {
  fact: {
    title: "Donald Trump - Hillary Clinton (2/3)",
    primaryDate: "2016-10-09",
    primaryDateKind: "recorded",
    kind: "video",
  },
  youtubeId: "ApTLB76Nmdg",
  durationSeconds: 5624,
  speakers: [
    {
      fullName: "Martha Raddatz",
      role: "moderator",
    },
    {
      fullName: "Anderson Cooper",
      role: "moderator",
    },
  ],
  plainText:
    "Good evening I'm Martha Raddatz from ABC News. And I'm Anderson Cooper from CNN. We want to welcome you to Washington University in St. Louis for the second presidential debate between Hillary Clinton and Donald Trump sponsored by the Commission on Presidential Debates. tonight's debate is a Town Hall format, which gives voters a chance to directly ask the candidates questions. Martha and I will ask follow-up questions but the night really belongs to the people in this room and to people across the country who have submitted questions online.",
  charOffsets: {
    "0": 0,
    "1": 5,
    "2": 13,
    "3": 17,
    "4": 24,
    "5": 32,
    "6": 37,
    "7": 41,
    "8": 47,
    "9": 51,
    "10": 55,
    "11": 64,
    "12": 71,
    "13": 76,
    "14": 81,
    "15": 84,
    "16": 89,
    "17": 92,
    "18": 100,
    "19": 104,
    "20": 107,
    "21": 118,
    "22": 129,
    "23": 132,
    "24": 136,
    "25": 142,
    "26": 146,
    "27": 150,
    "28": 157,
    "29": 170,
    "30": 177,
    "31": 185,
    "32": 193,
    "33": 201,
    "34": 205,
    "35": 212,
    "36": 218,
    "37": 228,
    "38": 231,
    "39": 235,
    "40": 246,
    "41": 249,
    "42": 262,
    "43": 271,
    "44": 281,
    "45": 288,
    "46": 291,
    "47": 293,
    "48": 298,
    "49": 303,
    "50": 311,
    "51": 317,
    "52": 323,
    "53": 330,
    "54": 332,
    "55": 339,
    "56": 342,
    "57": 351,
    "58": 355,
    "59": 359,
    "60": 370,
    "61": 381,
    "62": 388,
    "63": 392,
    "64": 394,
    "65": 399,
    "66": 403,
    "67": 413,
    "68": 423,
    "69": 427,
    "70": 431,
    "71": 437,
    "72": 444,
    "73": 452,
    "74": 455,
    "75": 459,
    "76": 466,
    "77": 469,
    "78": 474,
    "79": 479,
    "80": 483,
    "81": 486,
    "82": 493,
    "83": 500,
    "84": 504,
    "85": 512,
    "86": 516,
    "87": 521,
    "88": 531,
    "89": 541,
    "90": 549,
    length: 91,
  },
  timestamps: {
    "0": 0.75,
    "1": 0.9599999785423279,
    "2": 1.559999942779541,
    "3": 1.9199999570846558,
    "4": 2.128999948501587,
    "5": 2.5199999809265137,
    "6": 3.059999942779541,
    "7": 3.0899999141693115,
    "8": 3.6589999198913574,
    "9": 3.869999885559082,
    "10": 4.258999824523926,
    "11": 4.5289998054504395,
    "12": 4.679999828338623,
    "13": 5.099999904632568,
    "14": 5.309999942779541,
    "15": 5.489999771118164,
    "16": 5.548999786376953,
    "17": 5.699999809265137,
    "18": 5.879000186920166,
    "19": 6.089000225067139,
    "20": 6.239999771118164,
    "21": 7.199999809265137,
    "22": 7.289999961853027,
    "23": 7.5289998054504395,
    "24": 7.798999786376953,
    "25": 8.010000228881836,
    "26": 8.428999900817871,
    "27": 8.880000114440918,
    "28": 9.239999771118164,
    "29": 9.6899995803833,
    "30": 9.718999862670898,
    "31": 10.289999961853027,
    "32": 10.319999694824219,
    "33": 10.678999900817871,
    "34": 10.888999938964844,
    "35": 11.388999938964844,
    "36": 12.388999938964844,
    "37": 12.479999542236328,
    "38": 12.539999961853027,
    "39": 12.989999771118164,
    "40": 13.079999923706055,
    "41": 13.649999618530273,
    "42": 13.880000114440918,
    "43": 14.880000114440918,
    "44": 15.149999618530273,
    "45": 15.388999938964844,
    "46": 15.449999809265137,
    "47": 15.869999885559082,
    "48": 16.108999252319336,
    "49": 16.138999938964844,
    "50": 16.799999237060547,
    "51": 17.010000228881836,
    "52": 17.43000030517578,
    "53": 17.459999084472656,
    "54": 17.608999252319336,
    "55": 18.118999481201172,
    "56": 18.6299991607666,
    "57": 18.809999465942383,
    "58": 18.989999771118164,
    "59": 19.40999984741211,
    "60": 19.788999557495117,
    "61": 20.788999557495117,
    "62": 20.8799991607666,
    "63": 20.93899917602539,
    "64": 21.149999618530273,
    "65": 21.299999237060547,
    "66": 21.68899917602539,
    "67": 21.809999465942383,
    "68": 22.469999313354492,
    "69": 22.59000015258789,
    "70": 22.768999099731445,
    "71": 23.038999557495117,
    "72": 23.459999084472656,
    "73": 23.760000228881836,
    "74": 23.850000381469727,
    "75": 24.149999618530273,
    "76": 24.239999771118164,
    "77": 24.389999389648438,
    "78": 24.68899917602539,
    "79": 24.989999771118164,
    "80": 25.018999099731445,
    "81": 25.709999084472656,
    "82": 25.799999237060547,
    "83": 26.1299991607666,
    "84": 26.309999465942383,
    "85": 26.639999389648438,
    "86": 26.670000076293945,
    "87": 26.93899917602539,
    "88": 27.510000228881836,
    "89": 28.170000076293945,
    "90": 28.829999923706055,
    length: 91,
  },
  turnSpeaker: {
    "0": 0,
    "1": 1,
    length: 2,
  },
  turnWord: {
    "0": 0,
    "1": 8,
    length: 2,
  },
};

const timelineItems: TimelineItemData[] = [
  {
    id: "c7qu-ZE5SuipqSrOO30R3mnAA7K7nJ4fQ4zVIX0A2yg=",
    idx: "c7qu-ZE5SuipqSrOO30R3mnAA7K7nJ4fQ4zVIX0A2yg=",
    start: new Date("1788-06-21T00:00:00.000Z"),
    content: "United States Constitution",
    kind: "document",
  },
  {
    id: "pMHhbW_I-wquOfoyPFAVQu8DMLMpYVxhGT8R1x71hYA=",
    idx: "pMHhbW_I-wquOfoyPFAVQu8DMLMpYVxhGT8R1x71hYA=",
    start: new Date("1791-12-15T00:00:00.000Z"),
    content: "Bill of Rights",
    kind: "document",
  },
  {
    id: "-7DeOJAVJUsifUcIaZo7c41pol_guMxR6IEgYv28bHM=",
    idx: "-7DeOJAVJUsifUcIaZo7c41pol_guMxR6IEgYv28bHM=",
    start: new Date("1960-09-26T00:00:00.000Z"),
    content: "John F. Kennedy - Nixon (1/4)",
    kind: "video",
  },
  {
    id: "bl03RovlxbTZK0yu25_VikP0Y2xSj-J9oFyGUTWIOZQ=",
    idx: "bl03RovlxbTZK0yu25_VikP0Y2xSj-J9oFyGUTWIOZQ=",
    start: new Date("1960-10-07T00:00:00.000Z"),
    content: "John F. Kennedy - Nixon (2/4)",
    kind: "video",
  },
];

const documentFactLink: FT.FactLink = {
  fact: {
    title: "Amendment 13",
    primaryDate: "1865-12-06",
    primaryDateKind: "ratified",
    kind: "document",
  },
  hash: "o_dRqrNJ62wzlgLilTrLxkHqGmvAS9qTpa4z4pjyFqA=",
};

const documentNodes: FoundationNode[] = [
  {
    component: "p",
    innerHTML: [
      "Section 1. Neither slavery nor involuntary servitude, except as a punishment for crime whereof the party shall have been duly convicted, shall exist within the United States, or any place subject to their jurisdiction.",
    ],
    offset: 0,
  },
  {
    component: "p",
    innerHTML: [
      "Section 2. Congress shall have power to enforce this article by appropriate legislation.",
    ],
    offset: 218,
  },
];

const videoFactLink: FT.FactLink = {
  fact: {
    title: "Donald Trump - Hillary Clinton (2/3)",
    primaryDate: "2016-10-09",
    primaryDateKind: "recorded",
    kind: "video",
  },
  hash: "iEfwIxM7MmnOKb7zt4HqW8IxUWy6F7a236fSOQlUUWI=",
};

const videoNodes: CaptionNodeArr = [
  "Good evening I'm Martha Raddatz from ABC News.",
  "And I'm Anderson Cooper from CNN. We want to welcome you to Washington University in St. Louis for the second presidential debate between Hillary Clinton and Donald Trump sponsored by the Commission on Presidential Debates. tonight's debate is a Town Hall format, which gives voters a chance to directly ask the candidates questions. Martha and I will ask follow-up questions but the night really belongs to the people in this room and to people across the country who have submitted questions online.",
];

const cards: Card[] = [
  {
    username: "samples",
    titleSlug: "why-its-so-hard-to-have-peace",
    title: "Why it's so hard to have peace",
    blocks: [
      {
        kind: "paragraph",
        text:
          "During the cold war, anybody who wanted to negotiate with the evil Communists was “weak”.",
      },
      {
        kind: "paragraph",
        text:
          "Today, anybody who wants to negotiate with a Muslim country is “weak”.",
      },
      {
        kind: "video",
        range: [304, 321],
        videoId: "iEfwIxM7MmnOKb7zt4HqW8IxUWy6F7a236fSOQlUUWI=",
      },
      {
        kind: "paragraph",
        text:
          "Thank goodness there's at least one party who is willing to give peace a chance!",
      },
      {
        kind: "video",
        range: [246, 261],
        videoId: "EuBv33KFOcVItXjivwaqki89kC6YT63StCHz5wZAa7M=",
      },
      {
        kind: "paragraph",
        text: "Err..  Surely that's an outlier?",
      },
      {
        kind: "video",
        range: [190, 203],
        videoId: "EuBv33KFOcVItXjivwaqki89kC6YT63StCHz5wZAa7M=",
      },
      {
        kind: "paragraph",
        text:
          "Huh.  Too bad Jimmy Carter didn't think of something as catchy as MAGA.",
      },
    ],
    previewBlocks: [1, 2],
  },
  {
    username: "samples",
    titleSlug: "dont-worry-well-protect-the-constitution-for-you",
    title: "Don't worry, we'll protect the Constitution for you!",
    blocks: [
      {
        kind: "paragraph",
        text:
          "The system for appointing judges to the Supreme Court is quite complex. Only a lawyer with years of experience could understand it. But trust me – this President has no right to make an appointment! We’ll let the people decide in the next election, as demanded by our Constitution!!",
      },
      {
        kind: "document",
        excerptId: "hAGBMHs7k2yx_cmgp8I7r9VFE_NCuQ-QXsfDxjt9LJA=",
        viewRange: [17730, 18357],
        highlightedRange: [17730, 18357],
      },
      {
        kind: "paragraph",
        text:
          "Don’t bother reading the Constitution, it’s only for smart people like me. Trust me – the President is way out of line to think the Senate has any obligation to give his candidate a hearing!",
      },
    ],
    previewBlocks: [1, 0],
  },
];

const takeDocument: TakeDocument = {
  title: "Does a law mean what it says, or what it meant?",
  blocks: [
    {
      kind: "paragraph",
      text: "King: “I hereby declare that Seabiscuit shall be my royal horse!”",
    },
    {
      kind: "paragraph",
      text: "Subject: “But that’s MY horse!!”",
    },
    {
      kind: "paragraph",
      text:
        "King: “I said it – it’s the law of the land. Thief! Return my horse to me!”",
    },
    {
      kind: "paragraph",
      text: "...",
    },
    {
      kind: "paragraph",
      text:
        "That’s how people lived for a long time. The fix was to write laws down, so that the power of the government would no longer be subject to the arbitrary whims of any one person. Only trouble is, what does a law mean?",
    },
    {
      kind: "paragraph",
      text:
        "Textualism says that a law means what it says in its text. Simple enough. On the other hand, Originalism says that a law means what was meant when it was originally written. Figuring this out is a little trickier – you’ve got to be not just a lawyer but also an historian to have any chance of understanding the law. The upside of Originalism is that it can help the law to be more stable against the whims of a changing culture – our Constitution is more than 220 years old, and a lot has changed since then! A great example is the 2nd amendment:",
    },
    {
      kind: "document",
      excerptId: "pMHhbW_I-wquOfoyPFAVQu8DMLMpYVxhGT8R1x71hYA=",
      viewRange: [283, 439],
      highlightedRange: [283, 439],
    },
    {
      kind: "paragraph",
      text:
        "The Arms of the 21st century are a lot different than the Arms of 1789! A textualist has little choice in interpreting this law – clearly automatic rifles, grenades, rockets, and even nukes are protected. They are Arms, afterall!",
    },
    {
      kind: "paragraph",
      text:
        "An originalist has to go back to 1789 to understand the original meaning. Black powder muskets were the most powerful Arms of the time, so perhaps that is what the law should protect today? Although that captures the original technology, it doesn’t capture the original intent.",
    },
    {
      kind: "document",
      excerptId: "pMHhbW_I-wquOfoyPFAVQu8DMLMpYVxhGT8R1x71hYA=",
      viewRange: [283, 439],
      highlightedRange: [294, 368],
    },
    {
      kind: "paragraph",
      text:
        "In 1776, George Washington led an American militia to victory against a tyrannical royal crown. As the newly free colonies organized their national government, many were afraid that it might be just as oppressive as the royal crown had been. It sure seems like the original intent of the 2nd amendment was to enshrine the right of the citizenry to have the means for armed rebellion.",
    },
    {
      kind: "paragraph",
      text:
        "If our judges get to decide that the law means whatever they want it to mean, then we still live under a King, we’ve just changed his name to Judge. That’s why it’s important to apply consistent methodology when interpreting the law. But in this case, whether you’re a Textualist or an Originalist, I don’t see how the 2nd amendment allows for any of the gun restrictions in place today.",
    },
  ],
};

const initialRangeSliders: TimeRange[] = [
  {
    start: 0.75,
    end: 18.119,
    type: "VIEW",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Transcript",
  },
  {
    start: 0,
    end: 0,
    type: "SELECTION",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Clip",
  },
];

const zoomedRangeSliders: TimeRange[] = [
  {
    start: 3.659,
    end: 28.17,
    type: "VIEW",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Transcript",
  },
  {
    start: 3.87,
    end: 5.1,
    type: "SELECTION",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Clip",
  },
  {
    start: 3.7470000000000003,
    end: 5.223,
    type: "ZOOM",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Zoom",
  },
];

const unzoomedRangeSliders: TimeRange[] = [
  {
    start: 3.659,
    end: 28.17,
    type: "VIEW",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Transcript",
  },
  {
    start: 3.87,
    end: 5.1,
    type: "SELECTION",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Clip",
  },
  {
    start: 4,
    end: 82,
    type: "ZOOM",
    styles: {
      rail: {
        backgroundColor: "#d3dae3",
      },
      track: {
        backgroundColor: "#758aa8",
      },
      handle: {
        backgroundColor: "#758aa8",
        border: "1px solid #2c4770",
      },
    },
    label: "Zoom",
  },
];

const rangeStyle: StylesObject = {
  backgroundColor: "#758aa8",
};

const kennedyNixon: FT.VideoFactContent = {
  fact: {
    title: "Presidential Debate - Kennedy, Nixon (1 of 4)",
    primaryDate: "1960-09-26",
    primaryDateKind: "recorded",
    kind: "video",
  },
  youtubeId: "CsurHThBBkk",
  durationSeconds: 3536,
  speakers: [
    {
      fullName: "Howard K Smith",
      role: "Moderator",
    },
  ],
  plainText:
    "Good evening. The television and radio stations of the United States and their affiliated stations are proud to provide facilities for a discussion of issues in the current political campaign by the two major candidates for the presidency. The candidates need no introduction. The Republican candidate, Vice President Richard M. Nixon, and the Democratic candidate, Senator John F. Kennedy. According to rules set by the candidates themselves, each man shall make an opening statement of approximately eight minutes' duration and a closing statement of approximately three minutes' duration. In between the candidates will answer, or comment upon answers to questions put by a panel of correspondents. In this, the first discussion in a series of four - joint appearances, the subject matter has been agreed, will be restricted to internal or domestic American matters. And now for the first opening statement by Senator John F. Kennedy.",
  turnSpeaker: [0],
  charOffsets: {
    "0": 0,
    "1": 5,
    "2": 14,
    "3": 18,
    "4": 29,
    "5": 33,
    "6": 39,
    "7": 48,
    "8": 51,
    "9": 55,
    "10": 62,
    "11": 69,
    "12": 73,
    "13": 79,
    "14": 90,
    "15": 99,
    "16": 103,
    "17": 109,
    "18": 112,
    "19": 120,
    "20": 131,
    "21": 135,
    "22": 137,
    "23": 148,
    "24": 151,
    "25": 158,
    "26": 161,
    "27": 165,
    "28": 173,
    "29": 183,
    "30": 192,
    "31": 195,
    "32": 199,
    "33": 203,
    "34": 209,
    "35": 220,
    "36": 224,
    "37": 228,
    "38": 240,
    "39": 244,
    "40": 255,
    "41": 260,
    "42": 263,
    "43": 277,
    "44": 281,
    "45": 292,
    "46": 303,
    "47": 308,
    "48": 318,
    "49": 326,
    "50": 329,
    "51": 336,
    "52": 340,
    "53": 344,
    "54": 355,
    "55": 366,
    "56": 374,
    "57": 379,
    "58": 382,
    "59": 391,
    "60": 401,
    "61": 404,
    "62": 410,
    "63": 414,
    "64": 417,
    "65": 421,
    "66": 432,
    "67": 444,
    "68": 449,
    "69": 453,
    "70": 459,
    "71": 464,
    "72": 467,
    "73": 475,
    "74": 485,
    "75": 488,
    "76": 502,
    "77": 508,
    "78": 517,
    "79": 526,
    "80": 530,
    "81": 532,
    "82": 540,
    "83": 550,
    "84": 553,
    "85": 567,
    "86": 573,
    "87": 582,
    "88": 592,
    "89": 595,
    "90": 603,
    "91": 607,
    "92": 618,
    "93": 623,
    "94": 631,
    "95": 634,
    "96": 642,
    "97": 647,
    "98": 655,
    "99": 658,
    "100": 668,
    "101": 672,
    "102": 675,
    "103": 677,
    "104": 683,
    "105": 686,
    "106": 702,
    "107": 705,
    "108": 711,
    "109": 715,
    "110": 721,
    "111": 732,
    "112": 735,
    "113": 737,
    "114": 744,
    "115": 747,
    "116": 754,
    "117": 760,
    "118": 773,
    "119": 777,
    "120": 785,
    "121": 792,
    "122": 796,
    "123": 801,
    "124": 809,
    "125": 814,
    "126": 817,
    "127": 828,
    "128": 831,
    "129": 840,
    "130": 843,
    "131": 852,
    "132": 861,
    "133": 870,
    "134": 874,
    "135": 878,
    "136": 882,
    "137": 886,
    "138": 892,
    "139": 900,
    "140": 910,
    "141": 913,
    "142": 921,
    "143": 926,
    "144": 929,
    "145": 938,
    "146": 942,
    "147": 949,
    "148": 953,
    "149": 960,
    length: 150,
  },

  turnWord: [0],
  timestamps: {
    "0": 1.5199999809265137,
    "1": 2.5199999809265137,
    "2": 2.700000047683716,
    "3": 3.359999895095825,
    "4": 3.9590001106262207,
    "5": 4.110000133514404,
    "6": 4.21999979019165,
    "7": 4.949999809265137,
    "8": 5.068999767303467,
    "9": 5.190000057220459,
    "10": 5.609000205993652,
    "11": 5.639999866485596,
    "12": 6.179999828338623,
    "13": 6.320000171661377,
    "14": 6.359000205993652,
    "15": 7.139999866485596,
    "16": 7.980000019073486,
    "17": 8.369999885559082,
    "18": 8.399999618530273,
    "19": 8.75,
    "20": 9.119999885559082,
    "21": 9.569999694824219,
    "22": 9.84000015258789,
    "23": 10.468999862670898,
    "24": 10.888999938964844,
    "25": 11.189000129699707,
    "26": 11.489999771118164,
    "27": 11.579999923706055,
    "28": 11.880000114440918,
    "29": 12.09000015258789,
    "30": 12.84000015258789,
    "31": 13.069999694824219,
    "32": 13.109999656677246,
    "33": 13.380000114440918,
    "34": 13.619999885559082,
    "35": 14.369999885559082,
    "36": 14.579999923706055,
    "37": 14.6899995803833,
    "38": 15.149999618530273,
    "39": 15.869999885559082,
    "40": 16.350000381469727,
    "41": 16.52899932861328,
    "42": 16.670000076293945,
    "43": 17.100000381469727,
    "44": 17.81999969482422,
    "45": 18.358999252319336,
    "46": 18.799999237060547,
    "47": 19.049999237060547,
    "48": 19.59000015258789,
    "49": 19.739999771118164,
    "50": 19.889999389648438,
    "51": 20.038999557495117,
    "52": 20.608999252319336,
    "53": 20.709999084472656,
    "54": 21.719999313354492,
    "55": 22.139999389648438,
    "56": 22.618999481201172,
    "57": 22.858999252319336,
    "58": 23.09000015258789,
    "59": 23.809999465942383,
    "60": 24.809999465942383,
    "61": 24.93000030517578,
    "62": 25.108999252319336,
    "63": 25.52899932861328,
    "64": 25.559999465942383,
    "65": 25.790000915527344,
    "66": 26.368999481201172,
    "67": 27.09000015258789,
    "68": 27.65999984741211,
    "69": 28.018999099731445,
    "70": 28.27899932861328,
    "71": 28.43899917602539,
    "72": 28.559999465942383,
    "73": 28.889999389648438,
    "74": 28.948999404907227,
    "75": 29.479999542236328,
    "76": 30.179000854492188,
    "77": 30.420000076293945,
    "78": 30.809999465942383,
    "79": 31.139999389648438,
    "80": 31.518999099731445,
    "81": 31.618999481201172,
    "82": 31.829999923706055,
    "83": 32.130001068115234,
    "84": 32.57899856567383,
    "85": 33.290000915527344,
    "86": 33.56999969482422,
    "87": 33.71900177001953,
    "88": 34.40999984741211,
    "89": 35.040000915527344,
    "90": 35.459999084472656,
    "91": 35.65999984741211,
    "92": 36.119998931884766,
    "93": 36.29999923706055,
    "94": 36.5099983215332,
    "95": 36.98899841308594,
    "96": 37.59000015258789,
    "97": 37.790000915527344,
    "98": 38.34000015258789,
    "99": 38.54999923706055,
    "100": 39,
    "101": 39.62900161743164,
    "102": 39.689998626708984,
    "103": 39.869998931884766,
    "104": 40.22999954223633,
    "105": 40.36899948120117,
    "106": 41.369998931884766,
    "107": 41.54999923706055,
    "108": 42.32899856567383,
    "109": 42.540000915527344,
    "110": 42.888999938964844,
    "111": 43.290000915527344,
    "112": 43.558998107910156,
    "113": 43.64899826049805,
    "114": 43.97999954223633,
    "115": 44.0099983215332,
    "116": 44.53900146484375,
    "117": 45.52899932861328,
    "118": 46.11000061035156,
    "119": 46.349998474121094,
    "120": 46.73899841308594,
    "121": 46.95000076293945,
    "122": 47.34000015258789,
    "123": 47.540000915527344,
    "124": 47.87900161743164,
    "125": 48.41999816894531,
    "126": 48.53900146484375,
    "127": 49.22999954223633,
    "128": 49.2599983215332,
    "129": 50.03900146484375,
    "130": 50.18000030517578,
    "131": 50.7599983215332,
    "132": 51,
    "133": 51.62900161743164,
    "134": 51.959999084472656,
    "135": 52.558998107910156,
    "136": 52.819000244140625,
    "137": 53.0099983215332,
    "138": 53.279998779296875,
    "139": 53.81999969482422,
    "140": 54.29999923706055,
    "141": 54.44900131225586,
    "142": 54.95000076293945,
    "143": 55.22999954223633,
    "144": 55.5,
    "145": 60,
    "146": 60.400001525878906,
    "147": 60.900001525878906,
    "148": 61,
    "149": 62.61899948120117,
    length: 150,
  },
};

export {
  cards,
  documentFactLink,
  documentNodes,
  initialRangeSliders,
  kennedyNixon,
  rangeStyle,
  takeDocument,
  timelineItems,
  unzoomedRangeSliders,
  videoFactFast,
  videoFactLink,
  videoNodes,
  zoomedRangeSliders,
};
