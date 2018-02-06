import { BaseEntity } from './../../shared';

export class RNS_ARTICLE_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public aRTICLECODE?: string,
        public aRTICLECODEDESC?: string,
    ) {
    }
}
