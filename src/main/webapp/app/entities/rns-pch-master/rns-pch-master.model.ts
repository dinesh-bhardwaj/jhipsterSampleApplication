import { BaseEntity } from './../../shared';

export class RNS_PCH_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public pCHCODE?: string,
        public pCHNAME?: string,
    ) {
    }
}
