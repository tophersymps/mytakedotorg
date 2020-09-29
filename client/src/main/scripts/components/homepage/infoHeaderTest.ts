/*
 * MyTake.org website and tooling.
 * Copyright (C) 2020 MyTake.org, Inc.
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
import { Foundation } from "../../common/foundation";
import { imageVideoCut } from "../../common/social/SocialImage";
import { HomeSocials, SOCIAL_CLINTON, SOCIAL_TRUMP } from "./infoHeader";

export const useSocialsMock = async (): Promise<HomeSocials> => ({
  leftSocial: imageVideoCut(
    SOCIAL_CLINTON,
    await Foundation.justOneVideo(SOCIAL_CLINTON.fact),
    "home"
  ),
  rightSocial: imageVideoCut(
    SOCIAL_TRUMP,
    await Foundation.justOneVideo(SOCIAL_TRUMP.fact),
    "home"
  ),
});