import { BaseEntity } from './../../shared';

export class RNS_DEL_PLACE_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public cODE?: string,
        public cODEDESC?: string,
    ) {
    }
}
